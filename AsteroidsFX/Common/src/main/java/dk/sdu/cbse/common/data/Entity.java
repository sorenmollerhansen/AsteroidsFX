package dk.sdu.cbse.common.data;


public class Entity {
    
    private double[] polygonCoordinates;
    private double x;
    private double y;
    private double rotation;
    private float size;
    
    private int shootingCooldown = 0;            

    public String getID() {
        return ID.toString();
    }

    public int getShootingCooldown() {
        return shootingCooldown;
    }

    public void setShootingCooldown(int shootingCooldown) {
        this.shootingCooldown = shootingCooldown;
    }



    public void setPolygonCoordinates(double... coordinates ) {
        this.polygonCoordinates = coordinates;
    }

    public double[] getPolygonCoordinates() {
        return polygonCoordinates;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }
    
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getRotation() {
        return rotation;
    }

    public void setSize(float size) {
        this.size = radius;
    }
        
    public float getSize() {
        return this.size;
    }
}
