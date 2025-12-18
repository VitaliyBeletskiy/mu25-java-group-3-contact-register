# Digital Contact Register

Console-based Contact Management System developed as a group assignment for the course  
**Grundläggande Java-programmering**.

## Authors
- Petrit Rexha
- Vitaliy Beletskiy

## Description

The application allows users to manage contacts via a console interface.  
It demonstrates basic object-oriented programming principles and a layered architecture.

Two user roles are supported:
- Guest
- Administrator

## Features

- Search contacts by last name (first match)
- Search contacts by first name
- Search contacts by street name
- Free search across all contact fields
- Create, update, and delete contacts (admin only)
- Data persistence between program runs

## Contact Model

Each contact includes:
- First name, last name, age
- Address (street, house number, city, postal code)
- One or more phone numbers
- Unique UUID identifier

## Architecture

The project uses a simple layered architecture:
UI → Service → Repository → Storage

## How to Run

Run the application from the `Main` class and follow the console menu.
