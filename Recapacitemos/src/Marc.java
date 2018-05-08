import java.io.Serializable;

public class Marc implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1654738540667040774L;
	String name;
	int aprobados;
	boolean seta;
	
	
	public Marc(String name,int aprobados,boolean seta) {
		this.name=name;
		this.aprobados=aprobados;
		this.seta=seta;
	}
	
	public String toString() {
		return name+" "+aprobados+" "+seta;
	}

}
