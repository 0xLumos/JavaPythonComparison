import pickle

# Example of creating a malicious Pickle object
malicious_data = pickle.dumps(
    __import__('os').system('echo "Reverse shell"')
)

print(malicious_data)

# Simulating unsafe deserialization (e.g., from an untrusted source)
pickle.loads(malicious_data)
