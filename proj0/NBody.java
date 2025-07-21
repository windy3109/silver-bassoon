public class NBody {

   public static double readRadius(String filename) {
       In in = new In(filename);
       int count = in.readInt();
       double radius = in.readDouble();
       return radius;
   }

   public static Planet[] readPlanets(String filename) {
       In in = new In(filename);
       int count = in.readInt();
       double radius = in.readDouble();
       Planet[] planets = new Planet[count];
       for(int i = 0; i < count; i++){
           double x = in.readDouble();
           double y = in.readDouble();
           double Vx = in.readDouble();
           double Vy = in.readDouble();
           double mass = in.readDouble();
           String name = in.readString();
           planets[i] = new Planet(x, y, Vx, Vy, mass, name);
       }
       return planets;

   }
   public static void main(String[] args) {
       double T = Double.parseDouble(args[0]);
       double dt = Double.parseDouble(args[1]);
      String filename = args[2];
//       double T =20000000.0;
//       double dt = 20000;
//       String filename ="./data/3body.txt ";
       //20000000 20000 ./data/3body.txt
       String filename2 =  "./images/starfield.jpg";


       Planet[] planets = readPlanets(filename);

       double time = 0 ;
       for (; time <= T; time += dt) {
           StdDraw.enableDoubleBuffering();
           double[] xForces = new double[planets.length];
           double[] yForces = new double[planets.length];
           for (int i = 0; i < planets.length; i++) {
               xForces[i]= planets[i].calcNetForceExertedByX(planets);
               yForces[i]= planets[i].calcNetForceExertedByY(planets);
           }
           for (int i = 0; i < planets.length; i++) {
               planets[i].update(dt, xForces[i], yForces[i]);
           }



           StdDraw.setScale(-3e11, 3e11);

           /* Clears the drawing window. */
           StdDraw.clear();

           StdDraw.picture(0, 75, filename2);
           StdDraw.picture(-75, -75, filename2);
           StdDraw.picture(75, -75, filename2);

           for(Planet planet : planets) {
               planet.draw();
           }
           StdDraw.show();
           StdDraw.pause(10);

       }
       StdOut.printf("%d\n", planets.length);
       StdOut.printf("%.2e\n", readRadius(filename));
       for (int i = 0; i < planets.length; i++) {
           StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                   planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                   planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
       }
   }



}


