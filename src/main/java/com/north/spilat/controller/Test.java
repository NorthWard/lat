package com.north.spilat.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.jute.BinaryInputArchive;
import org.apache.jute.BinaryOutputArchive;
import org.apache.jute.Record;
import org.apache.zookeeper.proto.ConnectRequest;
import org.apache.zookeeper.proto.ConnectResponse;
import org.apache.zookeeper.proto.RequestHeader;
import org.apache.zookeeper.server.ByteBufferInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Test {
    public static Gson gson = new GsonBuilder().serializeNulls().create();
    public static void main(String[] args) throws IOException {
        //ZkClient zkClient = new ZkClient("localhost:2181");
       // List<String> l = zkClient.getChildren("/");
       connect();

        /*RequestHeader h = new RequestHeader();
        h.setType(ZooDefs.OpCode.getChildren);
        GetChildrenRequest request = new GetChildrenRequest();
        request.setPath("/");
       request.setWatch(false);


    */

    }

    public static final byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }
    private static void connect() throws IOException {
        ConnectRequest connectRequest = new ConnectRequest(0, 0,
                3000000, 0, new byte[16]);
        Socket socket=new Socket("localhost",2181);
        //根据输入输出流和服务端连接
        OutputStream outputStream=socket.getOutputStream();
        outputStream.write(createBB(null, connectRequest).array());
        // socket.shutdownOutput();//关闭输出流
        InputStream inputStream= socket.getInputStream();
        ByteBuffer buf = ByteBuffer.wrap(input2byte(inputStream));
        ByteBufferInputStream bbis = new ByteBufferInputStream(buf);
        BinaryInputArchive bbia = BinaryInputArchive.getArchive(bbis);
        ConnectResponse conRsp = new ConnectResponse();
        conRsp.deserialize(bbia, "connect");
        System.out.println(gson.toJson(conRsp));
    }

    public static ByteBuffer createBB(RequestHeader requestHeader, Record request) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BinaryOutputArchive boa = BinaryOutputArchive.getArchive(baos);
            // We'll fill this in later
            boa.writeInt(-1, "len");
            if (requestHeader != null) {
                requestHeader.serialize(boa, "header");
            }
            if (request instanceof ConnectRequest) {
                request.serialize(boa, "connect");
                // append "am-I-allowed-to-be-readonly" flag
                boa.writeBool(true, "readOnly");
            } else if (request != null) {
                request.serialize(boa, "request");
            }
            baos.close();
            ByteBuffer bb = ByteBuffer.wrap(baos.toByteArray());
            //
            bb.putInt(bb.capacity() - 4);
            bb.rewind();
            return  bb;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
