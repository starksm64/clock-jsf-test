package example.clock;

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

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/*
Use these for CDI:
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
*/
/*
Use this for JSF:
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
 */
@ManagedBean
@ApplicationScoped
public class Clock {
   @EJB
   private IClock clock;
   private ArrayList<TimeZone> zones;
   private ArrayList<DateInZone> dateInZones;

   @PostConstruct
   private void init() {
      zones = new ArrayList<>();
      zones.add(TimeZone.getTimeZone("America/Los_Angeles"));
      zones.add(TimeZone.getTimeZone("America/Chicago"));
      zones.add(TimeZone.getTimeZone("America/New_York"));
      zones.add(TimeZone.getTimeZone("Pacific/Honolulu"));
      zones.add(TimeZone.getTimeZone("Europe/London"));
      zones.add(TimeZone.getTimeZone("Europe/Paris"));
      zones.add(TimeZone.getTimeZone("Asia/Calcutta"));
      zones.add(TimeZone.getTimeZone("Asia/Tokyo"));
      zones.add(TimeZone.getTimeZone("Europe/Moscow"));
      System.out.printf("Created new %s\n", this);
   }
   @PreDestroy
   private void cleanUp() {
        System.out.println("cleanUp called");
    }

   public Date getNow() {
      Date now = clock.now();
      System.out.printf("Returning now=%s\n", now);
      return now;
   }

   public List<TimeZone> getZones() {
      return zones;
   }

   public List<DateInZone> getDateInZones() {
      Date now = clock.now();
      System.out.printf("Building times from(%s) for: %s\n", now, zones);
      SimpleDateFormat fmt = new SimpleDateFormat("yyyy.MM.dd @ HH:mm:ss z");
      dateInZones = new ArrayList<>();
      for(TimeZone zone : zones) {
         fmt.setTimeZone(zone);
         String time = fmt.format(now);
         DateInZone diz = new DateInZone(zone, time);
         dateInZones.add(diz);
      }
      return dateInZones;
   }
}
