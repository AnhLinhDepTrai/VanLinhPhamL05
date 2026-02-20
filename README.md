## <!--

## Author: Van Linh Pham

## Student ID: N01681546

## 

## -->



\[VanLinhPhamL05](https://github.com/AnhLinhDepTrai/VanLinhPhamL05)



## !\[Screenshot](cucthitbo.jpg)

## \# Fragment Lab 5 – Master-Detail Android App

## 

## \## Overview

## This Android application demonstrates the implementation of Fragments, Fragment communication, and dynamic UI updates using the Master–Detail design pattern.

## 

## The app displays a list of Android-related concepts. When a user selects an item from the list, the corresponding definition is displayed in a separate fragment.

## 

## ---

## 

## \## Features

## 

## \- Uses \*\*ListFragmentSmith\*\* to display a list of Android concepts.

## \- Uses \*\*DefinitionFragmentJohn\*\* to display the selected concept’s definition.

## \- Implements Fragment-to-Activity communication using a custom interface.

## \- Dynamically replaces fragments using `FragmentTransaction`.

## \- Supports proper lifecycle handling and prevents fragment duplication during screen rotation.

## \- Uses Bundle arguments to safely pass data between fragments.

## 

## ---

## 

## \## Architecture

## 

## \### 1. Activity (VanLinhActivity5)

## \- Hosts both fragments.

## \- Implements `OnItemSelectedListener` interface.

## \- Manages fragment transactions.

## \- Replaces the definition fragment when an item is selected.

## \- Uses `addToBackStack()` to enable back navigation.

## 

## \### 2. ListFragmentSmith

## \- Displays a list of Android concepts using `ListView` and `ArrayAdapter`.

## \- Sends selected item data to the Activity via interface callback.

## \- Uses a factory method (`newInstance`) and Bundle for safe data passing.

## 

## \### 3. DefinitionFragmentJohn

## \- Receives definition text via Bundle arguments.

## \- Displays the selected definition inside a `TextView`.

## \- Properly restores state during configuration changes.

## 

## \## Technologies Used

## 

## \- Java

## \- Android SDK

## \- AndroidX Fragment Library

## \- ListView and ArrayAdapter

