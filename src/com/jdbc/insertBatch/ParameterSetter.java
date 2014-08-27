package com.jdbc.insertBatch;

import java.sql.PreparedStatement;

public interface ParameterSetter<T> {

	public void setParameter(T t,PreparedStatement pst);
}
