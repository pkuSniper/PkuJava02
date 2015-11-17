package TestCollection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class TestCollection {
  HashSet<String> setall=new HashSet<String>();//��������ļ�
  HashSet<String> set1=new HashSet<String>();//��ŵ�һ���ļ�
  HashSet<String> set2=new HashSet<String>();//��ŵڶ����ļ�
  public void readTxtFile(String filePath,HashSet<String> set){
	  try {
          String encoding="GBK";
          File file=new File(filePath);
          if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
              InputStreamReader read = new InputStreamReader(
              new FileInputStream(file),encoding);//���ǵ������ʽ
              BufferedReader bufferedReader = new BufferedReader(read);
              String lineTxt = null;
              while((lineTxt = bufferedReader.readLine()) != null){
            	  String[] temp=lineTxt.split(" ");
            	  for(int i=0;i<temp.length;i++){
            		  set.add(temp[i]);
            	  }
              }
              read.close();
  }else{
      System.out.println("�Ҳ���ָ�����ļ�");
  }
  } catch (Exception e) {
      System.out.println("��ȡ�ļ����ݳ���");
      e.printStackTrace();
  }
  }
  public void outputAll(){
	 for(String value:setall){ 
		 System.out.print(value+" ");
	 }
  }
  public void outputIntersection(){
	  for(String value1:set1){
		  for(String value2:set2){
			  if(value1.equals(value2)){
				  System.out.print(value1+" ");
			  }
		  }
	  }
  }
  public int sum(HashSet<String> set){
	  return set.size();
  }
  public static void main(String[] args) {
	TestCollection test=new TestCollection();
	String filePath1="F://java��̿�//test1.txt";
	String filePath2="F://java��̿�//test2.txt";
	test.readTxtFile(filePath1, test.set1);
	test.readTxtFile(filePath2, test.set2);
	test.readTxtFile(filePath1, test.setall);
	test.readTxtFile(filePath2, test.setall);
	
	//test.outputAll();
	test.outputIntersection();
	//System.out.println(test.sum(test.set1));
	//System.out.println(test.sum(test.set2));
	
	
}
}
