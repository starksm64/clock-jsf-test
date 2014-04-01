package test.example.clock;
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

import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class WebClientTest {
   @Test
   public void accessWar() throws Exception {
      URL sendURL = new URL("http://localhost:8080/clock/index.xhtml");
      System.out.printf("Testing %s\n", sendURL);
      HttpURLConnection httpConn = (HttpURLConnection) sendURL.openConnection();
      httpConn.setRequestMethod("PUT");
      httpConn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
      Object content = httpConn.getContent();
      String msg = httpConn.getResponseMessage();
      System.out.printf("Received %s; msg=%s\n", content, msg);
   }
}
