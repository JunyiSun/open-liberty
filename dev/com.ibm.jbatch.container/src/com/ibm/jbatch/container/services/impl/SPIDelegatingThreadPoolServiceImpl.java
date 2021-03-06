/**
 * Copyright 2013 International Business Machines Corp.
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.jbatch.container.services.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.jbatch.container.exception.BatchContainerServiceException;
import com.ibm.jbatch.spi.BatchSPIManager;
import com.ibm.jbatch.spi.services.IBatchConfig;
import com.ibm.jbatch.spi.services.IBatchThreadPoolService;

/**
 * Note: this class is unused.
 */
public class SPIDelegatingThreadPoolServiceImpl implements IBatchThreadPoolService {
	
	private final static String sourceClass = SPIDelegatingThreadPoolServiceImpl.class.getName();
	private final static Logger logger = Logger.getLogger(sourceClass);

	public SPIDelegatingThreadPoolServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IBatchConfig batchConfig) {
		// Don't want to get/cache anything here since we want to delegate each time.
	}

	
	public void shutdown() throws BatchContainerServiceException {
		String method = "shutdown";
		if(logger.isLoggable(Level.FINER)) { logger.entering(sourceClass, method);	}
		
		ExecutorService delegateService = BatchSPIManager.getInstance().getExecutorServiceProvider().getExecutorService();
		delegateService.shutdownNow();
		
		if(logger.isLoggable(Level.FINER)) { logger.exiting(sourceClass, method);	}
	}

	public Future<?> executeTask(Runnable work, Object config) {
		String method = "executeTask";
		if(logger.isLoggable(Level.FINER)) { logger.entering(sourceClass, method);	}
		
		ExecutorService delegateService = BatchSPIManager.getInstance().getExecutorServiceProvider().getExecutorService();
		Future<?> retVal = delegateService.submit(work);
		
		if(logger.isLoggable(Level.FINER)) { logger.exiting(sourceClass, method);	}
		return retVal;
	}

    public Future<?> executeParallelTask(Runnable work, Object config) {
        String method = "executeParallelTask";
        if(logger.isLoggable(Level.FINER)) { logger.entering(sourceClass, method);  }
        
		ExecutorService delegateService = BatchSPIManager.getInstance().getExecutorServiceProvider().getExecutorService();
		Future<?> retVal = delegateService.submit(work);
        
        if(logger.isLoggable(Level.FINER)) { logger.exiting(sourceClass, method);   }
        return retVal;
    }
	
	
}
