package com.station.agent.stream.tcpclient;

import com.station.agent.disruptor.DisruptorService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TcpClientHandler extends SimpleChannelInboundHandler<byte[]> {
    private String owner;

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, byte[] bytes) throws Exception {
        DisruptorService.publishEvent(owner, bytes);
    }
}
