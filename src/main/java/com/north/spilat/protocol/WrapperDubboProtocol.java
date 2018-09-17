package com.north.spilat.protocol;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;

/**
 * @author laihaohua
 */
public class WrapperDubboProtocol extends DubboProtocol {

    @Override
    public <T> Exporter<T> export(Invoker<T> invoker) throws RpcException{
        System.out.println("invoker = [" + invoker + "]");
      return   super.export(invoker);
    }

    @Override
    public <T> Invoker<T> refer(Class<T> serviceType, URL url) throws RpcException {
        System.out.println("serviceType = [" + serviceType + "], url = [" + url + "]");
        return  super.refer(serviceType, url);
    }
}
