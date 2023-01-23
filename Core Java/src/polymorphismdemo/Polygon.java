package polymorphismdemo;

class Polygon {

    // method to render a shape
    public void render() {
      System.out.println("Rendering Polygon...");
    }
  

  static class Square extends Polygon {

    // renders Square
    public void render() {
      System.out.println("Rendering Square...");
    }
  }

  static class Circle extends Polygon {

    // renders circle
    public void render() {
      System.out.println("Rendering Circle...");
    }
  }
  } 
