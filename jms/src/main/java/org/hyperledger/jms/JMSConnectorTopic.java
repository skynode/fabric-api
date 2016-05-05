/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hyperledger.jms;

import org.hyperledger.connector.ConnectorException;
import org.hyperledger.connector.ConnectorTopic;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;

public class JMSConnectorTopic implements ConnectorTopic, JMSDestination {
    private Topic topic;

    public JMSConnectorTopic(Session session, String name) throws JMSException {
        topic = session.createTopic(name);
    }

    public Topic getTopic() {
        return topic;
    }

    @Override
    public Destination getDestination() {
        return topic;
    }

    @Override
    public String getName() throws ConnectorException {
        try {
            return topic.getTopicName();
        } catch (JMSException e) {
            throw new ConnectorException(e);
        }
    }
}
