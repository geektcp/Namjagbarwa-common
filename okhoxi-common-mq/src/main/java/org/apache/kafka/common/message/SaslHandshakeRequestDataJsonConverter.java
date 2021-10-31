/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import static org.apache.kafka.common.message.SaslHandshakeRequestData.*;

public class SaslHandshakeRequestDataJsonConverter {
    public static SaslHandshakeRequestData read(JsonNode _node, short _version) {
        SaslHandshakeRequestData _object = new SaslHandshakeRequestData();
        JsonNode _mechanismNode = _node.get("mechanism");
        if (_mechanismNode == null) {
            throw new RuntimeException("SaslHandshakeRequestData: unable to locate field 'mechanism', which is mandatory in version " + _version);
        } else {
            if (!_mechanismNode.isTextual()) {
                throw new RuntimeException("SaslHandshakeRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.mechanism = _mechanismNode.asText();
        }
        return _object;
    }
    public static JsonNode write(SaslHandshakeRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("mechanism", new TextNode(_object.mechanism));
        return _node;
    }
    public static JsonNode write(SaslHandshakeRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
