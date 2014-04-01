package example.weld;

/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import example.timesource.IClock;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.inject.Produces;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class WeldProducerMethods {
   private static final Logger logger = Logger.getLogger(WeldProducerMethods.class);

   @EJB
   private static IClock clockImpl;

   @Produces
   public static IClock getClockImplementation() {
      logger.infof("Returning SystemClock as implementation, %s\n", clockImpl);
      return clockImpl;
   }
}
