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
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Arrays;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.SaslAuthenticateRequestData.*;

public class SaslAuthenticateRequestDataJsonConverter {
    public static SaslAuthenticateRequestData read(JsonNode _node, short _version) {
        SaslAuthenticateRequestData _object = new SaslAuthenticateRequestData();
        JsonNode _authBytesNode = _node.get("authBytes");
        if (_authBytesNode == null) {
            throw new RuntimeException("SaslAuthenticateRequestData: unable to locate field 'authBytes', which is mandatory in version " + _version);
        } else {
            _object.authBytes = MessageUtil.jsonNodeToBinary(_authBytesNode, "SaslAuthenticateRequestData");
        }
        return _object;
    }
    public static JsonNode write(SaslAuthenticateRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("authBytes", new BinaryNode(Arrays.copyOf(_object.authBytes, _object.authBytes.length)));
        return _node;
    }
    public static JsonNode write(SaslAuthenticateRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
