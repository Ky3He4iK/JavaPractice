package dev.ky3he4ik.pr.pr10;

public class Complex {
    private int real;
    private int image;

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    public int getReal() {
        return real;
    }

    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "" + real + " + " + image + 'i';
    }
}
