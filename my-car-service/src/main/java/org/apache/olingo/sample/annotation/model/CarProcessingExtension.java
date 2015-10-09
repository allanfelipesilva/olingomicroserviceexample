package org.apache.olingo.sample.annotation.model;

import java.io.InputStream;

import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmExtension;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmSchemaView;

public class CarProcessingExtension implements JPAEdmExtension {

	@Override
	public void extendJPAEdmSchema(JPAEdmSchemaView view) {
		// TODO Auto-generated method stub

	}

	@Override
	public void extendWithOperation(JPAEdmSchemaView view) {
		view.registerOperations(Car.class, null);

	}

	@Override
	public InputStream getJPAEdmMappingModelStream() {
		// TODO Auto-generated method stub
		return null;
	}

}
