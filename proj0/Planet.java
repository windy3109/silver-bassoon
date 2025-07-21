public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static double G=6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
         this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
    }
    //计算距离
    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }



    public double calcForceExertedBy(Planet p) {
        return G * this.mass * p.mass/(this.calcDistance(p) * this.calcDistance(p));
    }


    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }


    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
    }


    public double calcNetForceExertedByX(Planet[] p) {
        double netForce = 0;
        for (Planet p1 : p) {
            if (this.equals(p1)){
                continue;
            }
            netForce += calcForceExertedByX(p1);
        }
        return netForce;
    }


    public double calcNetForceExertedByY(Planet[] p) {
        double netForce = 0;
        for (Planet p1 : p) {
            if (this.equals(p1)){
                continue;
            }
            netForce += calcForceExertedByY(p1);
        }
        return netForce;
    }
    public void update(double dt, double fx, double fy) {
        double ax = fx/this.mass;
        double ay = fy/this.mass;
        this.xxVel += dt * ax;
        this.yyVel += dt * ay;
        this.xxPos += xxVel * dt ;
        this.yyPos += yyVel * dt ;
    }
    public  void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}
