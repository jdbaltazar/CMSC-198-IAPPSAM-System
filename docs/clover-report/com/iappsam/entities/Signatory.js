var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":78,"id":999,"methods":[{"el":31,"sc":2,"sl":28},{"el":38,"sc":2,"sl":33},{"el":44,"sc":2,"sl":40},{"el":48,"sc":2,"sl":46},{"el":52,"sc":2,"sl":50},{"el":56,"sc":2,"sl":54},{"el":60,"sc":2,"sl":58},{"el":64,"sc":2,"sl":62},{"el":68,"sc":2,"sl":66},{"el":72,"sc":2,"sl":70},{"el":76,"sc":2,"sl":74}],"name":"Signatory","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]
