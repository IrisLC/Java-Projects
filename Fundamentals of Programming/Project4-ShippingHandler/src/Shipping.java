/** 
 * @author John Mattox
 * @modified Dr. Garrett Goodman
 * Shipping class for Project 4.
 */
public class Shipping {
   private int transportID;
   private int shipmentID;
   private String recieverName;
   private String trackingNumber;
   
   /**
   * This is the primary constructor for this class which creates a new Shipping object.
   * @param transportID an integer that represents the ID number of the person who is paying to ship the item
   * @param shipmentID an integer that represents the unique shipment number of the item that is being shipped
   * @param recieverName A String which is the name of the person or entinty that will be recieving the shippment
   * @param trackingNumber A string which is used to encode the location of the item and is used for tracking
   */
   public Shipping(int transportID, int shipmentID, String recieverName, String trackingNumber) {
      setTransportID(transportID);
      setShipmentID(shipmentID);
      setRecieverName(recieverName);
      setTrackingNumber(trackingNumber);
   }
   
   /**
   * A copy constructor that is provided to ease the creation of new objects with the same data as the original object.
   * @param ship A Shipping object that must be provided and whose attrbute's values will be copied to the new object
   */
   public Shipping(Shipping ship) {
      setTransportID(ship.getTransportID());
      setShipmentID(ship.getShipmentID());
      setRecieverName(ship.getRecieverName());
      setTrackingNumber(ship.getTrackingNumber());
   }
   
   /**
   * Returns an int with the transportID for this object
   * @return the integer transport ID for this object
   */
   public int getTransportID() {
      return this.transportID;
   }
   
   /**
   * Returns an int with the shipmentID for this object
   * @return the integer shipment ID for this object
   */
   public int getShipmentID() {
      return this.shipmentID;
   }

   /**
   * Returns a String with the recieverName for this object
   * @return the String reciever Name for this object
   */
   public String getRecieverName() {
      return this.recieverName;
   }

   /**
   * Returns a String with the trackingNumber for this object
   * @return the String tracking Number for this object
   */
   public String getTrackingNumber() {
      return this.trackingNumber;
   }
   
   /**
   * Returns this Shipping objects in the following String format
   *  [transportID, shipmentID, receieverName, trackingNumber]
   * @return A String that is made of the transportID, shipmentdID, recieverName, and trackingNumber plus some formatting characters
   */  
   @Override
   public String toString() {
      return ("[" + getTransportID() + ", " + getShipmentID() + ", " + getRecieverName() + ", " + getTrackingNumber() + "]");
   }
   
   /**
   * Compares if two Shipping objects are really the same object by testings if the shipmentIDs are the same
   * @param localObj the Shipping object you are comparing this object with
   * @return a boolean value which returns true if these two objects are the same shippment
   */   
   @Override 
   public boolean equals(Object localObj) {
      if (localObj instanceof Shipping) {
         Shipping ship = (Shipping) localObj;
         return (getShipmentID() == ship.getShipmentID());
      }
      return false;
   }
   
   /**
   * Creates a copy of this object.
   * @return The object that has been copied
   */
   @Override
   public Shipping clone() {
      return new Shipping(getTransportID(), getShipmentID(), getRecieverName(), getTrackingNumber());
   }
   
   /**
   * Sets a new value for the transport ID
   * @param t the new transport id
   */
   private void setTransportID(int t) {
      this.transportID = t;
   }
   
   /**
   * Sets a new value for the shipment ID
   * @param s the new shipmet id
   */
   private void setShipmentID(int s) {
      this.shipmentID = s;
   }
   
   /**
   * Sets a new value for the reciever name
   * @param r the new value for the reciever name
   */
   private void setRecieverName(String r) {
      this.recieverName = r;
   }
   
   /**
   * Sets a new value for the tracking number
   * @param t the new value for the tracking number
   */
   private void setTrackingNumber(String t) {
      this.trackingNumber = t;
   }  
   
}