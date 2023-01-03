
```shell
kubectl get nodes
kubectl cluster-info
kubectl describe node <node-name>
kubectl top node <node-name>
kubectl cordon <node-name> # Mark node as unschedulable (maintainance).
kubectl uncordon <node-name> # Mark node as schedulable (task ready).
kubectl drain <node-name> # Drain node in preparation for maintenance.
```

A pod is the smallest unit, it has a single IP and can contain 1 or more containers.