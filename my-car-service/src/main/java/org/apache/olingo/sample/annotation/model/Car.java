/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.olingo.sample.annotation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.olingo.odata2.api.annotation.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.annotation.edm.EdmEntityType;
import org.apache.olingo.odata2.api.annotation.edm.EdmFacets;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType.Type;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImportParameter;
import org.apache.olingo.odata2.api.annotation.edm.EdmKey;
import org.apache.olingo.odata2.api.annotation.edm.EdmNavigationProperty;
import org.apache.olingo.odata2.api.annotation.edm.EdmProperty;
import org.apache.olingo.odata2.api.exception.ODataException;

/**
 *
 */
@EdmEntityType(namespace = "MyFormula")
@EdmEntitySet(name = "Cars")
public class Car {

  @EdmKey
  @EdmProperty
  private String id;
  @EdmProperty
  private String model;
  @EdmNavigationProperty
  private Manufacturer manufacturer;
  @EdmNavigationProperty
  private Driver driver;
  @EdmProperty
  private Double price;
  @EdmProperty
  private Integer modelYear;
  @EdmProperty
  private Date updated;
  static List<Car> allanCars = new ArrayList<Car>();
  static {
	  Manufacturer chevrolet = new Manufacturer();
	  chevrolet.setFounded(new GregorianCalendar());
	  chevrolet.setId("chev");
	  chevrolet.setName("Chevrolet");
	  Car opala76 = new Car();
	  opala76.setId("opala");
	  opala76.setManufacturer(chevrolet);
	  opala76.setModel("Opala");
	  opala76.setModelYear(1976);
	  opala76.setPrice(15000D);
	  opala76.setUpdated(new Date());
     
      allanCars.add(opala76);
    }
  
  @EdmFunctionImport(name="returnAllanCars", returnType = @ReturnType(type = Type.ENTITY, isCollection = true), entitySet = "Cars" )
  public List<Car> returnAllanCars( @EdmFunctionImportParameter(name = "name", facets = @EdmFacets(nullable = false)) final String name)
		    throws ODataException {
	 if (name.equals("Allan")){
		return allanCars; 
	 }
	return null;
	  
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getModelYear() {
    return modelYear;
  }

  public void setModelYear(int modelYear) {
    this.modelYear = modelYear;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  @Override
  public String toString() {
    return "Car{" + "id=" + id + ", model=" + model + ", manufacturer id=" + manufacturer.getId() + ", driver id=" + driver.getId() + 
            ", price=" + price + ", modelYear=" + modelYear + ", updated=" + updated + '}';
  }
}
