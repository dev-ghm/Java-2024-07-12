package com.callor.iolist.models;

public class IolistVo {
	public String io_date;
	public String io_hour;
	public int io_divide;
	public String io_name;
	public int io_quantity;
	public int io_price;
	
	public int total() {
		int total = io_quantity * io_price;
		return total;
	}
	
	public String toString() {
		return "IolistVo [io_date=" + io_date + ",io_hour=" + io_hour + ",io_divide=" + io_divide + ",io_name =" + io_name + 
				",io_quantity=" + io_quantity + ",io_price=" + io_price + "]";
}
}
