package crypto

def encr = new KeyGen()
encr.getInstance()
//def e = encr.encrypt("n3tcool") // equals bjN0Y29vbA==
def e = encr.encrypt("n3tcool43456gdfsbh") // equals bjN0Y29vbA==
print "Encrypted: ${e}\n"
def d = encr.decrypt(e.toString())
println "Password is ${d}\n"
