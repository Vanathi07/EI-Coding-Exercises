# EXERCISE 1: 

# Problem Statement on Design patterns

## This exercise consists of six different use cases related to Stocks for better understanding of the Behavioural, Creational and Structural Design Patterns.

## Behavioral Pattern
Assignment of responsibilities between objects.

### 1. Observer Pattern
    - It is used to notify the customers (observers), when the stock prices are updated
    
### 2. Iterator Pattern
    - It is used to iterate over a collection of stock items

## Creational Pattern
Makes sytem independent of how its objects are created, composed and represented.

### 1. Singleton Pattern
    - Ensures that only one instance of StockMarket class exists

### 2. Factory Pattern
    - Allows subclass to alter type of stocks that will be created by resusing existing components

## Structural Pattern
Assemble objects and classes into larger structures to achieve multiple goals.

### 1. Adapter Pattern
    - It is used to convert Stock prices from type String to Double (incompatible interfaces)

### 2. Bridge Pattern
    - It is used to display stocks in different formats by splitting as abstraction and implementation

# Exercise 2:

# Problem Statement for Mini Projects

# Smart Office Management System

A console-based application to manage a smart office facility. The system should handle conference room bookings, occupancy 
detection, and automate the control of air conditioning and lighting based on room occupancy. 

## Features

1. **Office Configuration**:
   - Configure the number of conference rooms and their names.
   - Ensures a single instance of the office configuration using the Singleton pattern.

2. **Room Booking and Cancellation**:
   - Book and cancel bookings for conference rooms.
   - Automatically release unoccupied rooms after 5 minutes.

3. **Occupancy Detection**:
   - Detects room occupancy using sensors.
   - Notifies observers (lights and AC) to turn on/off based on occupancy status.

4. **Automated Control**:
   - Automatically controls lights and air conditioning based on room occupancy.

## Design Patterns Used

1. **Singleton Pattern**:
   - Ensures only one instance of the office configuration exists throughout the application.

2. **Observer Pattern**:
   - Manages the relationship between rooms and their sensors (occupancy sensor, light controller, air conditioning controller).
   - `Room` is the observable class, and the controllers and sensors are observers.

3. **Command Pattern**:
   - Encapsulates booking, cancellation, and status update logic in methods, allowing for flexible and extendable operations.


