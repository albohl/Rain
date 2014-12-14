package com.thecherno.rain.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	private int width, height;
	public int[] pixels;
	protected SpriteSheet sheet;

	//Level sprites here:
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x0000ff);

	//Player sprites here
	public static Sprite player_up = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite player_down = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite player_side = new Sprite(32, 1, 5, SpriteSheet.tiles);
	
	public static Sprite player_down_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite player_down_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	
	public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite player_side_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);
	
	public static Sprite player_up_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite player_up_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);

	public static Sprite dummy = new Sprite(32, 0, 0, SpriteSheet.dummy_down);
	
	//Projectile sprites here:
	public static Sprite projectile_wizard = new Sprite(16, 0, 0, SpriteSheet.projectile_wizard);
	
	//Particles
	public static Sprite particle_normal = new Sprite(1, 0x00ffaa00);
	
	protected Sprite(SpriteSheet sheet, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int width, int height, int colour) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColour(colour);
	}
	
	public Sprite(int size, int colour) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}
	
	public Sprite(int[] pixels, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	private void setColour(int colour){
		for (int i = 0; i < width * height; i++) {
			pixels[i] = colour;
		}
	}
	
	
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	private void load() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x+y*width] = sheet.pixels[(x + this.x) + (y + this.y)*sheet.WIDTH];
			}
		}
	}
	
}
