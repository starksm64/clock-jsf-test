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

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.TimeZone;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@FacesConverter("com.si.clock.ZoneConverter")
public class ZoneConverter implements Converter {
   @Override
   public Object getAsObject(FacesContext context, UIComponent component, String value) {
      TimeZone tz = TimeZone.getTimeZone(value);
      System.out.printf("getAsObject(%s) => %s\n", value, tz);
      return TimeZone.getTimeZone(value);
   }

   @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) {
      System.out.printf("getAsString(%s), ui=%s\n", value, component);
      if(value == null)
         return null;

      TimeZone tz = TimeZone.class.cast(value);
      return tz.getID();
   }
}