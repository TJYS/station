package com.station.agent.stream;

import com.station.agent.stream.propertys.StreamProperty;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.timeout.IdleStateHandler;

public abstract class AbstractClientDataStreamCreator<T extends StreamProperty> implements DataStreamCreator<T> {
    private final NioEventLoopGroup worker = new NioEventLoopGroup();
    private final Bootstrap bootstrap = new Bootstrap();
    private static final int SO_TIMEOUT = 6000;

    public AbstractClientDataStreamCreator() {
        bootstrap.group(worker);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.RCVBUF_ALLOCATOR, new DefaultMaxBytesRecvByteBufAllocator())
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new IdleStateHandler(SO_TIMEOUT, SO_TIMEOUT, SO_TIMEOUT))
                                .addLast(new ByteArrayDecoder())
                                .addLast(new ByteArrayEncoder());
                    }
                });
    }

    protected Channel connect(String ip, Integer port) throws InterruptedException {
        ChannelFuture future = bootstrap.connect(ip, port).sync();
        future.awaitUninterruptibly(SO_TIMEOUT);
        if (!future.isSuccess()){
            throw new InterruptedException("connect time out");
        }else {
            return future.channel();
        }
    }
}
