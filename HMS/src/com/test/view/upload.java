package com.test.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.h2.store.fs.FileUtils;
import org.springframework.stereotype.Component;

import com.bstek.dorado.uploader.DownloadFile;
import com.bstek.dorado.uploader.UploadFile;
import com.bstek.dorado.uploader.annotation.FileProvider;
import com.bstek.dorado.uploader.annotation.FileResolver;
import com.bstek.dorado.uploader.util.ParameterUtils;
import com.bstek.dorado.web.DoradoContext;

@Component
public class upload {
	private String getDestPath() {
		return System.getProperty("java.io.tmpdir") + File.separator + "upload";
	}

	@SuppressWarnings("unused")
	@FileResolver
	public Map<String, String> process1(UploadFile file,
			Map<String, Object> parameter) throws Exception {
		/*String uploadFolder = (String) parameter.get("uploadFolder");// ��ȡUploadAction��parameter��Ӧ�Ĳ���ֵ
		//String param2 = (String) parameter.get("param2");// ��ȡUploadAction��parameter��Ӧ�Ĳ���ֵ
		// �˴������ϴ�·���ɿͻ��˴�������Ҳ��������������������籾��һ������·����
		if (uploadFolder == null) {
			uploadFolder = "./target/upload";
		}
		File destFile = getDestFile(file.getFileName(), new File(uploadFolder));*/
		String param1 = (String) parameter.get("param1");// ��ȡUploadAction��parameter��Ӧ�Ĳ���ֵ
		String param2 = (String) parameter.get("param2");// ��ȡUploadAction��parameter��Ӧ�Ĳ���ֵ

		File destFile = getDestFile(file.getFileName(), new File(getDestPath()));
		try {
			file.transferTo(destFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, String> data = new HashMap<String, String>();
		data.put("fileName", destFile.getName());
		data.put("absolutePath", destFile.getAbsolutePath());
		return data;
	}

	@SuppressWarnings("unused")
	@FileResolver
	public void process2(UploadFile file, Map<String, Object> parameter)
			throws Exception {
		String name = (String) parameter.get("name");// ��ȡUploadAction��parameter��Ӧ�Ĳ���ֵ

		File destFile = getDestFile(file.getFileName(), new File(getDestPath()));
		try {
			file.transferTo(destFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File getDestFile(String fileName, File folder) {

		File destFile;

		// ���ļ�������ֱ�ӷ���
		if (!new File(folder, fileName).exists()) {
			destFile = new File(folder, fileName);
		} else {
			int i = 1, lastDotPos = fileName.lastIndexOf("."), len = fileName
					.length();

			String prefix = null, suffix = null, destFileName;

			// �ļ����в�����"."�������һλ��"."��ʱ��
			if (lastDotPos == len - 1 || lastDotPos == -1) {
				prefix = fileName;
				suffix = "";
			} else if (lastDotPos != -1) {
				prefix = fileName.substring(0, lastDotPos);
				suffix = fileName.substring(lastDotPos + 1);
			}
			do {
				if (suffix.length() == 0) {
					destFileName = String.format("%s_%d", prefix, i++);
				} else {
					destFileName = String.format("%s_%d.%s", prefix, i++,
							suffix);
				}
				destFile = new File(folder, destFileName);
			} while (destFile.exists());

		}

		FileUtils.createDirectory(destFile.getParent());

		return destFile;
	}

	private DownloadFile getDownloadFile(String fileName) throws IOException {
		String name = fileName;
		//String path = System.getProperty("java.io.tmpdir") + File.separator + "upload";
		ParameterUtils.validateParameterCharacters(name);
		URL url = this.getClass().getResource(name);
		//URL url = new URL(System.getProperty("java.io.tmpdir") + File.separator + "upload");
		InputStream stream = url.openConnection().getInputStream();
		DownloadFile file = new DownloadFile(name, stream);
		if ("UploadAction.pdf".equals(name)) {
			file.setName("UpdateAction�û�ָ��.pdf");
			//����ļ�����ʱ,�������Ʊ�����,���Բο����д����Զ���ת�뷽ʽ,������DownloadFile��fileName����
			//file.setFileName(new String("UpdateAction�û�ָ��.pdf".getBytes("UTF-8"),"iso8859-1"));
		}
		return file;
		
	}

	@FileProvider
	public DownloadFile downloadInline(Map<String, String> parameter)
			throws IOException {
		String fileName = parameter.get("file");
		DownloadFile file = getDownloadFile(fileName);
		return file;
	}

	@FileProvider
	public DownloadFile download(Map<String, String> parameter)
			throws IOException {
		String fileName = parameter.get("fileName");
		String path = System.getProperty("java.io.tmpdir") + File.separator + "upload" + File.separator + fileName;
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		DownloadFile dwfile = new DownloadFile(fileName, is);
		//DownloadFile file = getDownloadFile(fileName);
		return dwfile;
	}
	
	@FileProvider
	public DownloadFile showImage(Map<String, String> parameter)
			throws IOException {
		String fileName = parameter.get("file");
		ParameterUtils.validateParameterCharacters(fileName);
		String realPath = DoradoContext.getCurrent().getRequest().getSession().getServletContext().getRealPath("\\");
		if (realPath.endsWith("\\")) realPath = realPath.substring(0, realPath.length()-1);
		realPath += "images"+File.separator+fileName;
		return new DownloadFile(new File(realPath));
	}

}
