package com.springrestapi.entity;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.util.StreamUtils;

import com.app.config.CachedBodyServletInputStream;

public class MyRequestWrapper extends HttpServletRequestWrapper{

	private byte[] body=null;
	private byte[] cachedBody=null;
	
	
	
	public MyRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		// TODO Auto-generated constructor stub
		body = StreamUtils.copyToByteArray(request.getInputStream());
	}
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body);
		
		return new ServletInputStream() {
			@Override
			public int read() throws IOException {
				return byteArrayInputStream.read();
			}

			@Override
			public boolean isFinished() {
				// TODO Auto-generated method stub
				System.out.println("Finish");
				return true;
			}

			@Override
			public boolean isReady() {
				// TODO Auto-generated method stub
				System.out.println("Start");
				return true;
			}

			@Override
			public void setReadListener(ReadListener listener) {
				// TODO Auto-generated method stub
				
			}
		};
	}


	public byte[] getRequestBody() {
		return body;
	}
    @Override
    public BufferedReader getReader() throws IOException {
    	return new BufferedReader(new InputStreamReader(getInputStream()));
    }
}

