package com.north.spilat.listener;

import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.listener.ExporterListenerAdapter;

/**
 * @author laihaohua
 */
public class LatExporterListener extends ExporterListenerAdapter {
    @Override
    public void exported(Exporter<?> exporter) throws RpcException {
        System.out.println("exporter = [" + exporter + "]");
    }

    @Override
    public void unexported(Exporter<?> exporter) throws RpcException {
        System.out.println("exporter = [" + exporter + "]");
    }
}
