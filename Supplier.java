public class Supplier {
	private int idSupplier = 1;
	private String nameSupplier = "Fokstrot";
	private String telSupplier = "(044) 351-33-22";
	private String emailSupplier = "info@te.net.ua";
	private String bankSupplier = "Vostok";
	private int mfobankSupplier = 456345;
	private int bankAccountSupplier = 46748690;
	
	
	
	public int getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}
	public String getNameSupplier() {
		return nameSupplier;
	}
	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}
	public String getTelSupplier() {
		return telSupplier;
	}
	public void setTelSupplier(String telSupplier) {
		this.telSupplier = telSupplier;
	}
	public String getEmailSupplier() {
		return emailSupplier;
	}
	public void setEmailSupplier(String emailSupplier) {
		this.emailSupplier = emailSupplier;
	}
	public String getBankSupplier() {
		return bankSupplier;
	}
	public void setBankSupplier(String bankSupplier) {
		this.bankSupplier = bankSupplier;
	}
	public int getMfobankSupplier() {
		return mfobankSupplier;
	}
	public void setMfobankSupplier(int mfobankSupplier) {
		this.mfobankSupplier = mfobankSupplier;
	}
	public int getBankAccountSupplier() {
		return bankAccountSupplier;
	}
	public void setBankAccountSupplier(int bankAccountSupplier) {
		this.bankAccountSupplier = bankAccountSupplier;
	}
	public String toString(){
		 return nameSupplier + " " +  "\n" + "phone: " +  telSupplier + "\n" +  "e-mail: " + emailSupplier+"\n";
	 }

}
