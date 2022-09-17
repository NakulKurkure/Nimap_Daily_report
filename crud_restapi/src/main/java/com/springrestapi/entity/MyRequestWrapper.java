//package com.springrestapi.entity;
//
//import java.io.BufferedReader;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
////import java.io.InputStream;
//import java.io.InputStreamReader;
////import java.nio.charset.StandardCharsets;
//
//import javax.servlet.ReadListener;
//import javax.servlet.ServletInputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//
////import org.springframework.util.StreamUtils;
////
////import com.app.config.CachedBodyServletInputStream;
//
//public class MyRequestWrapper extends HttpServletRequestWrapper{
//
//	private String body;
////	private byte[] cachedBody=null;
//	
//	
//	
//	public MyRequestWrapper(HttpServletRequest request) throws IOException {
//		super(request);
//		// TODO Auto-generated constructor stub
////		body = StreamUtils.copyToByteArray(request.getInputStream());
//		body = null;
//        try (BufferedReader bufferedReader = request.getReader())
//        {
//            String line;
//            while ((line = bufferedReader.readLine()) != null)
//                body =body+ line;
//        }
//	}
//	
//	public String getBody() {
//		return body;
//	}
//
//	public void setBody(String body) {
//		this.body = body;
//	}
//
//	@Override
//	public ServletInputStream getInputStream() throws IOException {
//		
//		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
//		
//		
//		return new ServletInputStream() {
//			@Override
//			public int read() throws IOException {
//	            return byteArrayInputStream.read();
//	        }
//	        @Override
//	        public boolean isFinished() {
//	            return byteArrayInputStream.available() == 0;
//	        }
//	        @Override
//	        public boolean isReady() {
//	            return true;
//	        }
//	        @Override
//	        public void setReadListener(ReadListener readListener) {
//	            //do nothing
//	        }};
//	}
//
//
//    @Override
//    public BufferedReader getReader() throws IOException {
//    	return new BufferedReader(new InputStreamReader(getInputStream()));
//    }
//}
//
