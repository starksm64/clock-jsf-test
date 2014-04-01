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

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import java.util.TimeZone;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@ManagedBean
@NoneScoped
public class DateInZone {
   private TimeZone zone;
   private String date;

   public DateInZone() {
   }
   public DateInZone(TimeZone zone, String date) {
      this.zone = zone;
      this.date = date;
   }

   @PostConstruct
   private void init() {
      System.out.printf("%s.init(%s,%s)\n", this, zone, date);
   }

   public TimeZone getZone() {
      return zone;
   }

   public void setZone(TimeZone zone) {
      System.out.printf("%s.setZone(%s)\n", this, zone);
      this.zone = zone;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }
}
