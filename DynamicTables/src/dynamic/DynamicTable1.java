package dynamic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicTable1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			WebDriver driver;
			driver = new FirefoxDriver();
			driver.get("https://www.redbus.in/");
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
	//		driver.findElement(By.xpath(".//*[@id='onward_cal']")).click();
			String before =".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[";
			String between ="]/td[";
			String after ="]";
			
			Date systemdate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd");
			String dt = sdf.format(systemdate);
			System.out.println(dt);
			int flag=0;
			
	//Code to enter from and To
			String fromcitybefore =".//*[@id='search']/div/div[1]/div/ul/li[";
			String fromcityafter="]";
					
			
			//int citycount = driver.findElement(By.xpath(".//*[@id='search']/div/div[1]/div/ul/li")).getSize();
			
			driver.findElement(By.xpath(".//*[@id='src']")).clear();
			driver.findElement(By.xpath(".//*[@id='src']")).sendKeys("BIJAPUR");
//			Thread.sleep(2000);
			for(int x=1;x<10;x++){
				
				String city = driver.findElement(By.xpath(fromcitybefore+x+fromcityafter)).getText();
				if(city.equalsIgnoreCase("Bijapur")){
					driver.findElement(By.xpath(fromcitybefore+x+fromcityafter)).click();
					break;}
			}
			String Tocitybefore = ".//*[@id='search']/div/div[2]/div/ul/li[";
			String Tocityafter = "]";
			
			driver.findElement(By.xpath(".//*[@id='dest']")).clear();
			driver.findElement(By.xpath(".//*[@id='dest']")).sendKeys("BANGALORE");
			for(int y=1;y<10;y++){
				String city = driver.findElement(By.xpath(".//*[@id='search']/div/div[2]/div/ul/li["+y+"]")).getText();
				if(city.equalsIgnoreCase("Bangalore")){
					driver.findElement(By.xpath(Tocitybefore+y+Tocityafter)).click();
					break;}
			}
			
		//Below Code to click on today date	
			
			for (int i = 3; i <8; i++) {
				for(int j=1;j<=7;j++){
				String date = driver.findElement(By.xpath(before+i+between+j+after)).getText();
				System.out.println("i: "+i+"j:"+j+"Date: "+date);
				if(!date.equalsIgnoreCase("")){
				int datex = Integer.parseInt(date);
				if(datex<10 && datex>0)
					date= "0".concat(date);
				if(dt.equalsIgnoreCase(date)){
				System.out.println("Click today Date");
				driver.findElement(By.xpath(before+i+between+j+after)).click();
				flag=1;
				break;
				}}
								
				}
				
				if(flag==1)
					break;
				}
		
		//To click on Search Button
			driver.findElement(By.xpath(".//*[@id='search_btn']")).click();


	}

}
