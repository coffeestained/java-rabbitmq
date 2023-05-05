import { request } from '../util/HTTP';
import React, { Component } from 'react';

interface IProps {

};

interface IState {
  loading: boolean;
};

export default class Dashboard extends Component<IProps, IState> {
  static displayName = Dashboard.name;

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    this.getMapBoxKey();
  }

  async getMapBoxKey() {
    const response = await request(
      {
        url: 'api/v1/amqp/ping',
        options: {
          method: "GET",
        }
      },
    );
    console.log(response);
    this.setState({ loading: false });
  }

  render() {
    //const { mapboxKey } = this.state ?? {};

    return (
      <div>
        <div className="row gy-2">
            <div className="col-6">
              <div className="shadow-lg p-3 mb-5 bg-body rounded">
                <h1>AMQP Dashboard</h1>
                <p>This dashboard demonstrates HTTP, Web Sockets and Charting / BI features with data supplied from a Java Spring Boot application and RabbitMQ broker.</p>
              </div>
            </div>
            <div className="col-6">
              <div className="shadow-lg p-3 mb-5 bg-body rounded">
                <h2>Quick Access</h2>
              </div>
            </div>
            <div className="col-12">
              <div className="shadow-lg p-3 mb-5 bg-body rounded">
                <h2>
                    Charting
                </h2>
              </div>
            </div>
        </div>

      </div>
    );
  }
}
