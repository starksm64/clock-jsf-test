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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.TimeZone;

@ManagedBean(name = "tzwrapper")
@ViewScoped
public class TZWrapper {
   TimeZone zone;

   public TimeZone getZone() {
      return zone;
   }

   public void setZone(TimeZone zone) {
      this.zone = zone;
   }
}
