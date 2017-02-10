package com.bi.unblock.model;

public class Block {
	private int id;
	private int xComponent;
	private int yComponent;
	private int width;
	private String axis;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getxComponent() {
		return xComponent;
	}
	public void setxComponent(int xComponent) {
		this.xComponent = xComponent;
	}
	public int getyComponent() {
		return yComponent;
	}
	public void setyComponent(int yComponent) {
		this.yComponent = yComponent;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getAxis() {
		return axis;
	}
	public void setAxis(String axis) {
		this.axis = axis;
	}
	public Block(int id, int xComponent, int yComponent, int width, String axis) {
		super();
		this.id = id;
		this.xComponent = xComponent;
		this.yComponent = yComponent;
		this.width = width;
		this.axis = axis;
	}
	@Override
	public String toString() {
		return "Block [id=" + id + ", xComponent=" + xComponent + ", yComponent=" + yComponent + ", width=" + width
				+ ", axis=" + axis + "]";
	}
	
}
