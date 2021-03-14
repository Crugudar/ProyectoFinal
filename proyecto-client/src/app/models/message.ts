export class Message {
   
    constructor(
        private _id: number,
        private _name: string,
        private _email: string,
        private _phone: number,
        private _isRead: boolean,
        private _message: string,
        
      ) { }
  
    public get message(): string {
        return this._message;
    }
    public set message(value: string) {
        this._message = value;
    }
    public get isRead(): boolean {
        return this._isRead;
    }
    public set isRead(value: boolean) {
        this._isRead = value;
    }
    public get phone(): number {
        return this._phone;
    }
    public set phone(value: number) {
        this._phone = value;
    }
    public get email(): string {
        return this._email;
    }
    public set email(value: string) {
        this._email = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

    
    
}
