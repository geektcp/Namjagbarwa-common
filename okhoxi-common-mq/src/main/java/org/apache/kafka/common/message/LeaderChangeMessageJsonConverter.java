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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.LeaderChangeMessage.*;

public class LeaderChangeMessageJsonConverter {
    public static LeaderChangeMessage read(JsonNode _node, short _version) {
        LeaderChangeMessage _object = new LeaderChangeMessage();
        JsonNode _leaderIdNode = _node.get("leaderId");
        if (_leaderIdNode == null) {
            throw new RuntimeException("LeaderChangeMessage: unable to locate field 'leaderId', which is mandatory in version " + _version);
        } else {
            _object.leaderId = MessageUtil.jsonNodeToInt(_leaderIdNode, "LeaderChangeMessage");
        }
        JsonNode _votersNode = _node.get("voters");
        if (_votersNode == null) {
            throw new RuntimeException("LeaderChangeMessage: unable to locate field 'voters', which is mandatory in version " + _version);
        } else {
            if (!_votersNode.isArray()) {
                throw new RuntimeException("LeaderChangeMessage expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<Voter> _collection = new ArrayList<Voter>(_votersNode.size());
            _object.voters = _collection;
            for (JsonNode _element : _votersNode) {
                _collection.add(VoterJsonConverter.read(_element, _version));
            }
        }
        JsonNode _grantingVotersNode = _node.get("grantingVoters");
        if (_grantingVotersNode == null) {
            throw new RuntimeException("LeaderChangeMessage: unable to locate field 'grantingVoters', which is mandatory in version " + _version);
        } else {
            if (!_grantingVotersNode.isArray()) {
                throw new RuntimeException("LeaderChangeMessage expected a JSON array, but got " + _node.getNodeType());
            }
            ArrayList<Voter> _collection = new ArrayList<Voter>(_grantingVotersNode.size());
            _object.grantingVoters = _collection;
            for (JsonNode _element : _grantingVotersNode) {
                _collection.add(VoterJsonConverter.read(_element, _version));
            }
        }
        return _object;
    }
    public static JsonNode write(LeaderChangeMessage _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("leaderId", new IntNode(_object.leaderId));
        ArrayNode _votersArray = new ArrayNode(JsonNodeFactory.instance);
        for (Voter _element : _object.voters) {
            _votersArray.add(VoterJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("voters", _votersArray);
        ArrayNode _grantingVotersArray = new ArrayNode(JsonNodeFactory.instance);
        for (Voter _element : _object.grantingVoters) {
            _grantingVotersArray.add(VoterJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("grantingVoters", _grantingVotersArray);
        return _node;
    }
    public static JsonNode write(LeaderChangeMessage _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class VoterJsonConverter {
        public static Voter read(JsonNode _node, short _version) {
            Voter _object = new Voter();
            JsonNode _voterIdNode = _node.get("voterId");
            if (_voterIdNode == null) {
                throw new RuntimeException("Voter: unable to locate field 'voterId', which is mandatory in version " + _version);
            } else {
                _object.voterId = MessageUtil.jsonNodeToInt(_voterIdNode, "Voter");
            }
            return _object;
        }
        public static JsonNode write(Voter _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("voterId", new IntNode(_object.voterId));
            return _node;
        }
        public static JsonNode write(Voter _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
