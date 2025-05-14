/**
 * Represents a three-dimensional vector with x, y, and z components.
 * Provides methods for vector arithmetic, normalization, magnitude calculation,
 * and angle computation. Derrick
 */
public class Vector3D {
  private final double x;
  private final double y;
  private final double z;

  /**
   * Constructs a new Vector3D with the given x, y, and z components.
   *
   * @param x the x-component of the vector
   * @param y the y-component of the vector
   * @param z the z-component of the vector
   */
  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Returns the x-component of this vector.
   *
   * @return the x-component
   */
  public double getX() {
    return x;
  }

  /**
   * Returns the y-component of this vector.
   *
   * @return the y-component
   */
  public double getY() {
    return y;
  }

  /**
   * Returns the z-component of this vector.
   *
   * @return the z-component
   */
  public double getZ() {
    return z;
  }

  /**
   * Returns a string representation of this vector in the format (x, y, z),
   * with each component rounded to two decimal places.
   *
   * @return the string representation of the vector
   */
  @Override
  public String toString() {
    return String.format("(%.2f, %.2f, %.2f)", x, y, z);
  }

  /**
   * Calculates the magnitude (length) of this vector.
   *
   * @return the magnitude of the vector
   */
  public double getMagnitude() {
    return Math.sqrt(x * x + y * y + z * z);
  }

  /**
   * Returns a normalized version of this vector (unit vector).
   *
   * @return the normalized vector
   * @throws IllegalStateException if the vector has zero magnitude
   */
  public Vector3D normalize() {
    double magnitude = getMagnitude();
    if (magnitude == 0) {
      throw new IllegalStateException("Normalization impossible with zero magnitude");
    }
    return new Vector3D(x /  magnitude, y/ magnitude, z / magnitude);
  }

  /**
   * Adds this vector to another vector and returns the resulting vector.
   *
   * @param other the vector to add
   * @return the sum of the two vectors
   */
  public Vector3D add(Vector3D other) {
    return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
  }

  /**
   * Multiplies this vector by a scalar and returns the resulting vector.
   *
   * @param scalar the constant to multiply with
   * @return the scaled vector
   */
  public Vector3D multiply(double scalar) {
    return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
  }

  /**
   * Computes the dot product of this vector and another vector.
   *
   * @param other the vector to compute the dot product with
   * @return the dot product result
   */
  public double dotProduct(Vector3D other) {
    return x * other.x + y * other.y + z * other.z;
  }

  /**
   * Calculates the angle in degrees between this vector and the specified vector.
   * The angle is computed using the dot product formula:
   * angle = acos((A · B) / (|A| * |B|)).
   *
   * @param other the other Vector3D to compare with
   * @return the angle between this vector and the other vector, in degrees
   * @throws IllegalStateException if either vector has zero magnitude
   */
  public double angleBetween(Vector3D other) {
    double magnitude1 = this.getMagnitude();
    double magnitude2 = other.getMagnitude();

    if (magnitude1 == 0 || magnitude2 == 0) {
      throw new IllegalStateException("Angle impossible with zero vector");
    }

    double dot = this.dotProduct(other);
    double cosTheta = dot / (magnitude1 * magnitude2);
    cosTheta = Math.max(-1.0, Math.min(1.0, cosTheta));
    double angleRad = Math.acos(cosTheta);
    return Math.toDegrees(angleRad);
  }
}