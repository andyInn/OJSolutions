package alibaba;
//自定义类型做map的key需要重载hashCode()和equals两个方法，否则出错
//见http://segmentfault.com/a/1190000002655085
public class SingleMatch {
	
	private Integer horse1;
	private Integer horse2;
	
	public SingleMatch(){
	}
	
	public SingleMatch(Integer horse1, Integer horse2){
		this.horse1=horse1;
		this.horse2=horse2;
	}
	
	public Integer getHorse1() {
		return horse1;
	}

	public void setHorse1(Integer horse1) {
		this.horse1 = horse1;
	}

	public Integer getHorse2() {
		return horse2;
	}

	public void setHorse2(Integer horse2) {
		this.horse2 = horse2;
	}
	
}
