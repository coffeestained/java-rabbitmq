import React, { Component } from 'react';
import { Container } from 'reactstrap';
import { NavMenu } from './nav/NavMenu';

export default class Layout extends Component {
  static displayName = Layout.name;

  render() {
    return (
      <div>
        <NavMenu />
        <Container id="router-outlet" tag="main">
          {this.props.children}
        </Container>
      </div>
    );
  }
}
