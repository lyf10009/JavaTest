package com.jdbc.insertBatch;

public abstract class AbstractInsertRecords implements InsertRecords{

	protected  int batchSize = 1000;
	
	protected int count;
	
	protected String sql;
	
	public int getBatchSize()	{
		return batchSize;
	}

	public void setBatchSize(int batchSize)	{
		this.batchSize = batchSize;
	}

	public abstract void close();

	public abstract void flush();
}
