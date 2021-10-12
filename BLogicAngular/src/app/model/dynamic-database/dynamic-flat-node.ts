export class DynamicFlatNode {
  constructor(public id: number, public type: string, public item: any, public level = 1, public expandable = false,
              public isLoading = false) {}
}
