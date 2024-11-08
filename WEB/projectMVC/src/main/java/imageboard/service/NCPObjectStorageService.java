package imageboard.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsAsyncClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class NCPObjectStorageService {
	private String accessKey = "DB4C182639EA0D2A7774	";
	private String secretKey = "EBC06508F6F5B49028F165C10784A4748B1912FD";
	private String regionName = "kr-standard";
	private String endPoint = "https://kr.object.ncloudstorage.com";


	final AmazonS3 s3;
	
	
	public NCPObjectStorageService() {
		s3 = AmazonS3ClientBuilder 
				.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
				.build();
	}


	public String uploadFile(String bucketName, String directory, File file) {
//		String fileName = file.getName();
		String fileName = UUID.randomUUID().toString() ;
		FileInputStream fileIn = null;
		
		try {
			fileIn = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ObjectMetadata objectMetadata = new ObjectMetadata();
//		objectMetadata.setContentType("image/jpeg");

		Path path = Paths.get(file.getAbsolutePath());
		String contentType = null;
		try {
			contentType = Files.probeContentType(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		objectMetadata.setContentType(contentType);
		objectMetadata.setContentLength(file.length());
		
		PutObjectRequest putObjectRequest = 
					new PutObjectRequest(bucketName, directory + fileName,
											fileIn,
											objectMetadata)
					.withCannedAcl(CannedAccessControlList.PublicRead); // 리소스에 대한 접근 권한
		
		s3.putObject(putObjectRequest);
		
		return fileName;
	}
}
