import java.util.Scanner;

public class AreaCalculator {

  public static double areaOfCircle(double radius) {
    return Math.PI * radius * radius;
  }

  public static double areaOfRectangle(double length, double width) {
    return length * width; 
  }

  public static double areaOfTriangle(double base, double height) {
    return 0.5 * base * height; 
  }

  public static double areaOfTrapezoid(double base1, double base2, double height) {
    return 0.5 * (base1 + base2) * height; // Use the formula
  }

  public static double areaOfParallelogram(double base, double height) {
    return base * height;
  }

  public static double areaOfEllipse(double majorAxis, double minorAxis) {
    return Math.PI * majorAxis * minorAxis;
  }

  public static double areaOfSector(double radius, double angle) {
    return 0.5 * radius * radius * Math.toRadians(angle);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Choose a shape to calculate its area:");
    System.out.println("1. Circle");
    System.out.println("2. Rectangle");
    System.out.println("3. Triangle");
    System.out.println("4. Trapezoid");
    System.out.println("5. Parallelogram");
    System.out.println("6. Ellipse");
    System.out.println("7. Sector");

    int choice = sc.nextInt();

    double radius, length, width, base, height, base1, base2, majorAxis, minorAxis, angle;

    switch (choice) {
      case 1:
        System.out.println("Enter the radius of the circle:");
        radius = sc.nextDouble();
        System.out.println("The area of the circle is: " + areaOfCircle(radius));
        break;
      case 2:
        System.out.println("Enter the length and width of the rectangle:");
        length = sc.nextDouble();
        width = sc.nextDouble();
        System.out.println("The area of the rectangle is: " + areaOfRectangle(length, width));
        break;
      case 3:
        System.out.println("Enter the base and height of the triangle:");
        base = sc.nextDouble();
        height = sc.nextDouble();
        System.out.println("The area of the triangle is: " + areaOfTriangle(base, height));
        break;
      case 4:
        System.out.println("Enter the two bases and height of the trapezoid:");
        base1 = sc.nextDouble();
        base2 = sc.nextDouble();
        height = sc.nextDouble();
        System.out.println("The area of the trapezoid is: " + areaOfTrapezoid(base1, base2, height));
        break;
      case 5:
        System.out.println("Enter the base and height of the parallelogram:");
        base = sc.nextDouble();
        height = sc.nextDouble();
        System.out.println("The area of the parallelogram is: " + areaOfParallelogram(base, height));
        break;
      case 6:
        System.out.println("Enter the major and minor axes of the ellipse:");
        majorAxis = sc.nextDouble();
        minorAxis = sc.nextDouble();
        System.out.println("The area of the ellipse is: " + areaOfEllipse(majorAxis, minorAxis));
        break;
      case 7:
        System.out.println("Enter the radius and angle of the sector:");
        radius = sc.nextDouble();
        angle = sc.nextDouble();
        System.out.println("The area of the sector is: " + areaOfSector(radius, angle));
        break;
      default:
        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
    }
    sc.close();
  }
}
