class Planet {
  float radius;
  float angle;
  float distance;
  Planet []planets;
  float orbitSpeed;
  PVector v;
  
  PShape globe;

  Planet(float r, float d, float o) {
    v = PVector.random3D();
    
    
    radius = r;
    distance = d;
    v.mult(distance);
    angle = random( TWO_PI);
    orbitSpeed = o;
    //println(angle); 
    
    noStroke();
    fill(0,255,255);
    //globe.setTexture(img);
    
    globe = createShape(SPHERE,radius);
    sphere(radius);
    
    
    
}

void orbit () {
  angle = angle + orbitSpeed;
  if (planets !=null) {
    for(int i= 0;i< planets.length; i++) {
      planets[i].orbit();
    }
  }
}
void spawnMoons(int total, int level) {
  planets = new Planet [total];
  for(int i= 0;i< planets.length; i++) {
  float r= radius/(level*1.5);
  float d =  random((radius +r),(radius+r)*2);
  float o = random(-0.1,0.1);
    planets[i] = new Planet(r,d,o);
    if (level <2) {
      int num = int (random (0,3));
    planets[i] .spawnMoons(1, level+1);
}
}
}
void show() {
  pushMatrix();
  noStroke();
  fill(255);
  
  PVector v2 =new PVector (1,0,1);
  PVector p = v.cross(v2);
  rotate (angle, p.x,p.y,p.z);
  stroke(255);
  //line(0,0,0,v.x,v.y,v.z);
   //line(0,0,0, p.x, p.y, p.z);
  
  translate(v.x,v.y,v.z);
  noStroke();
  shape(globe);
  //sphere(radius);
 //ellipse (0,0, radius *2,radius*2);
if (planets !=null) {
for (int i= 0;i< planets.length; i++) {
  planets[i].show();
}
}
popMatrix();
}
}
