
###1. Why Cloud Storage ?

**Availability**: The motto of cloud storage services is to have data availablity anywhere, anytime. Users can access
 their files/photo from any device whenever and wherever they like.
 
 **Reliability** Another benefit of cloud storage is that it offers 100% reliability and durability of data.
 Cloud storage ensures that users will never lose their data by keeping multiple copies of the data stored on
  different geographically located srvers,
  
 **Scalibility**: Users will never have to worry about getting out of storage space.
 With cloud storage you have unlimited storage as long as you are ready to pay for it.
  

###2. Requirements and Goals of the system

a) User should be able to upload and download their files/photos from any device.

b) Users should be able to share files or folders with other users.

c) Our service should support automatic synchronization between devices, i.e,. after updating a file on one device
, it should get synchronized on all devices.

d) The system should support storing large files up to a GB.

e) Atomicity, Consistency. Isolation and Durability of all file operations should be guaranteed..

f) The system shluld support offline editing. Users should be able to add / delete / modify files while offile, and
 as soon as they come online, all their changes should be synced to the remote servers and other online devices.

 
###3. Design considerations

- We should expect huge read and write volumes.
- Read to write ratio is expected to be nearly the same.
- Internally, files can be stored in small parts or chunks; this can provide a lot of benefits i.e. all failed
 operations shall only be retried for smaller parts of a file. If a user fails to upload a file, then only the
  failing chunk will be retried.

- We can reduce the amount of data exchange by transferring updated chunks only.
  
- By removing duplicate chunks, we can save storage space and bandwidth usage.

- Keeping a local copy of the metadata (file name, size, etc.) with the client can save a lot of round trip to the
 server
 
###4. Capacity Estimation and constraints

- we assume that we have 500M total users, and 100M daily active users
- we assume that on average each user connects from three different devices
- we assume that average file size is 100KB, this would give us 10 petabytes of total storage
