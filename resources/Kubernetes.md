# K8s Components.
A pod is the smallest unit, it has a single IP and can contain 1 or more containers.

## Node.
+ Physical or visrtualized machine.

## POD.
+ Smallest unit of k8s.
+ Abstraction over container.
+ Usually one application per pod.
+ Each pod gets its own IP address. (default virtual network)
+ New IP address on recreation.

## Service.
+ Permanent IP address.
+ Lifecycle of pod and service are not connected.
    + Internal (db)
    + External (frontend)
+ Load balanceer.
+ Pod and node inter-communication.

## Ingress.
+ Does external forwarding to the service. (External requests)
+ Ingress -> Service (Internal) -> Pod.
    + It needs an ingress controller. (Evaluate al rules and manage redirections)
+ For the ingress controller you can use K8s Nginx Ingress Controller,.

## Config-map. 
+ External configuration to the application.
+ No need to recreate containers on var change.

## Secret.
+ Used to store secrets (credentials using base64).
+ The built-in security is not enabled by default.

## Volumes.
+ Persist database data.\
+ Attaches physical (local or remote) storage to the pod.

## Deployments.
+ In practice, instead of working with pods, it will be deployments.
+ Abstraction of pods.
+ Database can't be replicated. (data inconsistencies)
+ Use for stateless apps.
+ Blueprint for creating pods.

## StatefulSet.
+ Ment for databases.
+ Use for stateful apps or databases. (rw synchronize)

# K8s Architecture.
Each node has multiple nodes on it, so 3 processes must be installed on every worker node. (use and schedule)
+ Container runtime.
+ kubelet. Interacts with the container runtime and the machine (node)
+ Kube proxy. Forward requests avoiding network overhead.

Master nodes: 
4 processes run on every master node:
+ API Server. (gateway and gatekeeper for authentication)
+ Scheduler.
+ Controller Manager. (detects cluster state changes)
+ etcd. (cluster changes are saved in a key value store -> cluster brain) It holds the current status of every K8s component.
The have the followinfg jobs:
+ Schedule pods.
+ Monitor.
+ Re-schedule/Re-start pods.
+ Join a new node.

+ Worker Nodes do the work.
Deployment manages a ReplicaSet which manages a Pod.

# Configuration file parts.
## I. Metadata
```yaml
# Deployment.
apiVersion: apps/v1
kind: Deployment
metadata:
    name: <name>
    labels:
```
## II. Specification.
Specific to the kind.
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
    name: <name>
    labels:
spec:
    replicas:
    selector:
    template: #This config applies to a pod.
```
## III. Status.
Add the status and update the config.
# Namespaces.
Can be considered as a virtual cluster.
It has 4 namespacess for default:
+ **Kube-system**.
+ **kube-public**. Public accesible data.
+ **kube-node-lease**. Holds information about nodes heartbeats.
+ **default**. User resources are created here.
It is possible to access services from another namespace.
```yaml
data:
    db_url: my-service.database
```
# kubectl commands.
```shell
kubectl cluster-info
kubectl create deployment <name> --image=<image> [options]
kubectl get deployment
kubectl get replicaset
kubectl edit deployment <name>
kubectl logs <pod-name>
kubectl describe pod <name>
kubectl exec -it <pod-name> -- bin/bash # Gets an interactive terminal (it).
kubectl delete deployment <name> 
kubectl apply -f <yaml-file-name> {--namespace=<name>}# Execute a configuration file. 
kubectl create namespace <name>
kubectl get namespace
kubectl api-resources --namespaced=false # Release components that are not bound to a namespace.
kubectl get configmap -o yaml
kubectl get all -n <namespace> # Get all the components within a namespace.
kubectl get ingress {-n <namespace-name> --watch} 
kubectl describe ingress <name> {-n <namespace-name>}
kubectl delete pod <pod-name>
kubectl get nodes
kubectl cluster-info
kubectl describe node <node-name>
kubectl top node <node-name>
kubectl cordon <node-name> # Mark node as unschedulable (maintainance).
kubectl uncordon <node-name> # Mark node as schedulable (task ready).
kubectl drain <node-name> # Drain node in preparation for maintenance.
```
